
let gdata;
let tBody;
let universe;

function myfun() {
    let v;
    v = document.getElementById("select").value;
    console.log("desa" + v);
    switch (v) {
        case "Show assending order by name":
            gdata.sort(function (a, b) {
                return a.uname.localeCompare(b.uname)
            });
            gdata.forEach(g => {
                console.log(g.uname);
            });
            document.getElementById("mytable").innerHTML = '';

            displayItems(gdata);
            break;
        case "font size to 100":
            document.getElementById("myl").style.fontSize = "100";
            break;
        case "font color change":
            alert("font color change");
            break;
        case "dark mode":
            document.getElementById("top").style.background = "violet";
            document.getElementById("body").style.background = "black";
            break;
        default:
            break;

    }

}

function view() {
    $.ajax({
        url: "http://localhost:9090/serv1",
        type: "GET",
        dataType: "json",
        success: function (data) {
            displayItems(data);

        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function displayItems(mydata) {
    gdata = mydata;
    console.log(mydata);
    $('#mytable').DataTable({
        "pageLength": 3,
        pagination: "bootstrap",
        filter: true,
        data: mydata,
        destroy: true,
        lengthMenu: [5, 10, 25],
        pageLength: 10,
        "columns": [
            { "data": "app_id" },
            { "data": "p_id" },
            { "data": "uname" },
            { "data": "app_date" },
            { "data": "hos_id" },
            { "data": "doc_id" }
        ]
    });

    // tBody = document.getElementById("mytable");

    // mydata.forEach((ele) => {
    //     // $("#mytable tbody").append(newRowContent);
    //     tr = tBody.insertRow();
    //     let td1 = tr.insertCell(0);
    //     let sn = document.createTextNode(ele.app_id);
    //     td1.appendChild(sn);
    //     let td2 = tr.insertCell(1);
    //     let ai = document.createTextNode(ele.p_id);
    //     td2.appendChild(ai);
    //     let td3 = tr.insertCell(2);
    //     let ali = document.createTextNode(ele.uname);
    //     td3.appendChild(ali);
    //     let td4 = tr.insertCell(3);
    //     let cn = document.createTextNode(ele.app_date);
    //     td4.appendChild(cn);
    //     let td5 = tr.insertCell(4);
    //     let c = document.createTextNode(ele.hos_id);
    //     td5.appendChild(c);
    //     let td6 = tr.insertCell(4);
    //     let c1 = document.createTextNode(ele.doc_id);
    //     td6.appendChild(c1);
    // });

}

function gotodate() {

    let dta = {
        app_date: document.getElementById("iptdate").value
    }
    $.ajax({
        url: "http://localhost:9090/servdate",
        type: "POST",
        data: JSON.stringify(dta),
        success: function (data) {  
            checkandprint(JSON.parse(data));
            
        },
        error: function (error) {
            console.log(error);
        },
    });
}

//here check tomorrow
function checkandprint(data) {
    const button = document.createElement("button");
    $(".docdiv").remove();
    data.forEach(element => {
        console.log(element.doc_id + ":" + element.count + ":" + element.doc_name + ":" + element.d_special);
        if (element.count == 0) {
            let aButton = button.cloneNode(false);
            aButton.innerText = "Accept Appoiment ";
            aButton.setAttribute("onclick", `editItem()`);            
            div = document.createElement("div");
            div.className="docdiv";
            div.style.width = "15%";
            div.style.height = "40%";
            div.style.background = "#b3ffd9";
            div.style.color = "black";
            div.style.fontFamily = "Arial, Helvetica, sans-serif";
            div.innerHTML = "<center><h1>Doctor</h1>" + element.doc_id + "<br><h3>" + element.doc_name + "</h3><h4>" + element.d_special + "</h4></center>";
          
            div.style.float = "left";
            div.style.marginLeft = "8%";
            div.style.marginBottom = "4%";
            // div.style.display = "flex";
            div.style.justifyContent = "center";
            div.style.alignItems = "center";
            div.style.boxShadow = "4px 3px 10px #9494949c";
            document.body.appendChild(div);
        }
    });

}