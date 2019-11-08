function loadVG(form){
    document.getElementById("formID").innerHTML= form.formID;
    document.getElementById("formName").innerHTML= form.formName;
    document.getElementById("formApproval").innerHTML= form.formMetaScore;
}

function getForm(){
	console.log("inside getForm");
	let Formid=document.getElementById("formIDInput").value;
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange= function(){
        console.log("in ORSC "+ xhr.readyState);
        if(xhr. readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var vg= JSON.parse(xhr.responseText);
            loadForm(form);
        }
    }
    //fix this link once the JAVA/server has been updated
    xhr.open ("GET", "http://localhost:8080/"+formid, true);
    xhr.send();
}
function postForm(){
    console.log("in postForm");
    var xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC "+ xhr.readyState);
        if(xhr. readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
         }
     }
     //fix this link once the Java/Server has been updated
     xhr.open("POST","http://localhost:8080/", true);
     var payload= jsonBuilder();
     xhr.send(payload);
}

function jsonBuilder(){
    var elements= document.getElementById("formForm").elements;
    var obj={};
    for(var i=0;i<elements.length-1; i++){
        var item = elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }

    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}

window.onload= function(){
    console.log("in onload");
    this.document.getElementById("formSubmitGet").addEventListener("click", getForm, false);
    this.document.getElementById("formFormSubmit").addEventListener("click", postForm, false);
}