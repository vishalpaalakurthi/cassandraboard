const container = document.getElementsByClassName('container');

const inputQuery = document.getElementById('cqlinput');
const submitQuery = document.getElementById('submitQuery');
const resultTable = document.getElementById('resultTable');
const addServer = document.getElementById('addServer');

const userName = document.getElementById('username');
const password = document.getElementById('password');
const ipaddress = document.getElementById('ipaddress');

const viewKeySpaces = document.getElementById('viewKeySpaces');
const keyspaces = document.getElementById('keyspaces');
const tableNames = document.getElementById('tableNames');

const nodeMsg=document.getElementById('nodeMsg');
const ddNodes=document.getElementById('ddnodes');
const qDataLoader= document.getElementById('qDataLoader');
qDataLoader.style.display="none";


let columns;
let resultData;


ddNodes.onchange = (e) => {
    selectedNode = e.target.value;
    nodeMsg.innerHTML="Active Node "+selectedNode;
    alert('Changed Node to '+ selectedNode);
    getTableNames();

}

function connectToCassndra() {
    alert("connectToCassndra")
}

submitQuery.onclick = () => {
    let iquery = inputQuery.value.trim();
    if(iquery) {
        if(!(iquery.toUpperCase().indexOf("select".toUpperCase()) === 0)) {
            alert("you can able to execute only select queries");
            return;
        }
        qDataLoader.style.display="flex";
        getResultByQuery(inputQuery.value)
    } else {
        alert("Input is Empty");
    }
};

var getResultByQuery = async (query) => {
    var response  = await httpGetAsync("/query?node="+selectedNode+"&query="+query+";")

}

function httpGetAsync(theUrl)
{
    fetch(theUrl)
    .then(data => data.json())
    .then(res => {
        if(res) {
            columns=res[0];
            resultData=res[1];
            qDataLoader.style.display="none";
            generateTable();
        }
    })
}

function generateTable() {
    var th="<div class='th'>{_html_}</div>";
    var td="<div class='td'>{_html_}</div>";
    var tr="<div class='tr'>{_html_}</div>";
    var thData="";
    var trData="";
    resultTable.innerHTML="";
    columns.forEach(value => {
        thData = thData + td.replace("{_html_}",value);
    })
    th=th.replace("{_html_}",thData);
    for(var i in resultData) {
        var td_s="";
        resultData[i].forEach(value => {
            td_s = td_s+td.replace("{_html_}",value);
        })
        let tr_=tr.replace("{_html_}",td_s);
        trData = trData + tr_;
    }
    resultTable.innerHTML=th+" "+trData;
}

function getTableNames() {
    let tablesQuery = "select table_name from system_schema.tables where keyspace_name = 'ace2three';";
    fetch("/query?node="+selectedNode+"&query="+tablesQuery)
        .then(data => data.json())
        .then(res => {
            if(res) {
                let columns=res[0];
                let resultData=res[1];
                generateTableNames(columns, resultData);
            }
        })
}

function generateTableNames(columnNames, records) {
    var th="<div class='th'>{_html_}</div>";
    var td="<div class='td'>{_html_}</div>";
    var tr="<div class='tr'>{_html_}</div>";
    var thData="";
    var trData="";
//    columnNames.forEach(value => {
//        thData = thData + td.replace("{_html_}",value);
//    })
//    th=th.replace("{_html_}",thData);
    for(var i in records) {
        var td_s="";
        records[i].forEach(value => {
            td_s = td_s+td.replace("{_html_}",value);
        })
        let tr_=tr.replace("{_html_}",td_s);
        trData = trData + tr_;
    }
    //tableNames.innerHTML=th+" "+trData;
    tableNames.innerHTML=trData;
}

function getExistingNodes() {
    fetch("/nodes")
        .then(data => data.json())
        .then(res => {
            if(res) {
                buildNodesDropdown(res);
            }
        })
}

function buildNodesDropdown(nodes) {
    let _options="";
    for(var index in nodes) {
        let node = nodes[index]
        let option= "<option value='"+ node.split("|")[0] + "' >"+ node +"</option>";
        _options = _options + option;
    }
    ddNodes.innerHTML = _options;
    selectedNode=ddNodes.options[ddNodes.selectedIndex].value;
    nodeMsg.innerHTML="Active Node "+selectedNode;
    getTableNames();
}
getExistingNodes();