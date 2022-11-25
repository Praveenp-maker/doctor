let f;
let filt = [];
let div;
document.getElementById("statusdiv").style.display = "none";
f = document.getElementById("hv").value;
console.log(f);
if (f == "patient") {
    document.getElementById("doctor2").style.display = "none";
} else {
    console.log("he was a doctor");
    document.getElementById("patient").style.display = "none";
}

function showdoct() {
    $.ajax({
        url: "http://localhost:9090/dserv",
        type: "GET",
        dataType: "json",
        success: function (data) {

            displaydoctor(data);

        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function displaydoctor(d_data) {

    $(".docdetail").remove();
    document.getElementById("statusdiv").style.display = "none";
    d_data.forEach(element => {
        console.log(element.d_name1);
        div = document.createElement("div");
        div.className = "alldoc";
        div.className = "docdetail";
        div.style.width = "15%";
        div.style.height = "40%";
        div.style.background = "#b3ffd9";
        div.style.color = "black";
        div.style.fontFamily = "Arial, Helvetica, sans-serif";

        div.innerHTML = "<p>Doctor</p><br><br><br><br><br> " + element.d_name1 + "<br><br><br><br><br>" + element.spi;
        div.style.float = "left";
        div.style.marginLeft = "8%";
        div.style.marginBottom = "4%";
        div.style.display = "flex";
        div.style.justifyContent = "center";
        // div.style.alignItems="center";
        div.style.boxShadow = "4px 3px 10px #9494949c";
        document.body.appendChild(div);
    });

}
function status(e) {
    $.ajax({
        url: "http://localhost:9090/serv1",
        type: "GET",
        dataType: "json",
        success: function (data) {
            $(".alldoc").remove();
            displayItems(data, e);
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function displayItems(data, e1) {
    const xu = document.getElementById("statusdiv");
    if (xu.style.display === "none") {
        xu.style.display = "block";
        console.log("iam none");
    } else {
        console.log("iam block");
        xu.style.display = "none";
    }
    // document.getElementById("statusdiv").style.display = "block";
    $(".hidere").remove();
    $(".hidere2").remove();
    document.createElement("statustbl");
    tBody = document.getElementById("statustbl");
    th = tBody.insertRow();
    th.className = "hidere2";
    let th11 = th.insertCell(0);
    th11.innerHTML = "APPLICATION ID";
    let th22 = th.insertCell(1);
    th22.innerHTML = "PATIENT ID";
    let th33 = th.insertCell(2);
    th33.innerHTML = "USER NAME";
    let th44 = th.insertCell(3);
    th44.innerHTML = "APPOIMENT DATE";
    let th55 = th.insertCell(4);
    th55.innerHTML = "DOCTOR ID";
    let th66 = th.insertCell(5);
    th66.innerHTML = "HOSPITAL ID";
    let th67 = th.insertCell(6);
    th67.style.background = "green";
    th67.innerHTML = "STATUS";
    data.forEach(ele => {

        if (ele.p_id == e1) {
            th = tBody.insertRow();
            let th1 = th.insertCell(0);
            th1.innerHTML = ele.app_id;
            let th2 = th.insertCell(1);
            th2.innerHTML = ele.p_id;
            let th3 = th.insertCell(2);
            th3.innerHTML = ele.uname;
            let th4 = th.insertCell(3);
            th4.innerHTML = ele.app_date;
            let th5 = th.insertCell(4);
            th5.innerHTML = ele.doc_id;
            let th6 = th.insertCell(5);
            th6.innerHTML = ele.hos_id;
            let th7 = th.insertCell(6);
            if (ele.status == 1) {
                th7.style.background = "#abf0ab";
                th7.innerHTML = "Appoiment Confirmed";
            } else {
                th7.style.background = "#e49836";
                th7.innerHTML = "waiting list";
            }

            th.className = "hidere";
        }
    });

}
function datewice(s) {
    $.ajax({
        url: "http://localhost:9090/serv1",
        type: "GET",
        dataType: "json",
        success: function (data) {
            
            go(data, s);
            // window.location.reload();


        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}

function go(data, s) {


    const button = document.createElement("button");
    tBody = document.getElementById("astatus");
    tBody.className = "stable";
    data.forEach(ele => {
        if (ele.doc_id == s) {
            button.className = "statusbutton";
            button.style.background = "orange";
            if (ele.status == 1) {
                button.style.background = "green";
        
            }
            button.style.height = "30px";
            button.style.border = "none";
            button.style.padding = "10px";
            button.style.borderRadius = "7px";
            button.style.color = "white";
            let editButton = button.cloneNode(false);
            editButton.innerText = "Accept Appoiment ";
            editButton.setAttribute("onclick", `editItem(${ele.app_id})`);
            th = tBody.insertRow();
            th.style.background = "white";
            th.style.height = "80px";
            th.style.marginLeft = '50px';
            let th11 = th.insertCell(0);
            th11.innerHTML = ele.app_id;
            let th22 = th.insertCell(1);
            th22.innerHTML = ele.p_id;
            let th33 = th.insertCell(2);
            th33.innerHTML = ele.uname;
            let th44 = th.insertCell(3);
            th44.innerHTML = ele.app_date;
            let th55 = th.insertCell(4);
            th55.appendChild(editButton);
        }


    });
}


function editItem(ana) {
    // alert(ana);
    // let senddata={
    //     app_id:ana,
    // }
    // $.ajax({
    //     url: "http://localhost:9090/makeapp",
    //     type: "GET",
    //     data: JSON.stringify(senddata),
    //     success: function (data) {
    //        console.log("go");
    //     },
    //     error: function (error) {
    //         console.log(`Error ${error}`);
    //     },
    // });


    let dta = {
        app_id: ana
    }
    $.ajax({
        url: "http://localhost:9090/makeapp",
        type: "PUT",
        data: JSON.stringify(dta),
        success: function (data) {
            // checkandprint(JSON.parse(data));

        },
        error: function (error) {
            console.log(error);
        },
    });
}


























// var image = new Image(); image.src ="back.jpg" ;
// const div3 = document.getElementById('slide1')
// const clone = div3.cloneNode(true);
// // clone.id = "slide1";
// clone.innerHTML="saaaaa";


// document.getElementById("maindiv").appendChild(clone);
