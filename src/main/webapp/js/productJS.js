function makeTemplate(data, clickedCategory) {
//총 개수 변경하기 
	var divCounts = document.querySelector("#counts");  
//	var textNode = document.createTextNode("바로 예매 가능한 행사가 총 "+data.count+"개 있습니다.");
//	divCounts.replaceChild(textNode, divCounts.firstChild);
	
	var countsHTML = document.querySelector("#countArea").innerHTML;  
	var resultCounts = ""
	resultCounts = countsHTML.replace("{count}", data.count);
	
	
	var countsNode = document.createElement("div"); //필수
	countsNode.innerHTML = resultCounts;
	
	document.querySelector("#counts").replaceChild(countsNode, divCounts.firstChild);
	
//새로운 카테고리가 눌렸을 때, 기존에 있던 product 지우기
	if(seeMoreCount == 0) {
		
		var productsForRemove = document.querySelector(".productList");
		
		while (productsForRemove.hasChildNodes()) {
			productsForRemove.removeChild(productsForRemove.firstChild);
		}
	}
	
//product 넣기
	var html = document.getElementById("tabcontent").innerHTML;

    var resultHTML = "";
    for (var i = 0; i < data.list.length; i++) {
       resultHTML = html.replace("{save_file_name}", data.list[i].save_file_name)
            .replace("{description}", data.list[i].description)
            .replace("{place_name}", data.list[i].place_name)
            .replace("{content}", data.list[i].content)
            
//       console.log(resultHTML); 
       
       var products = document.createElement("div");
       products.innerHTML = resultHTML;
       document.querySelector(".productList").appendChild(products);
    }
}

function sendAjax(url, clickedCategory) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {

    	var data = JSON.parse(oReq.responseText);
//    	console.log(typeof data); 
    	
        makeTemplate(data, clickedCategory);
    });
    oReq.open("GET", url);
    oReq.send();
}

var category_num;
var seeMoreCount;

//tabCategory 눌렸을 때 
var tabCategory = document.querySelector(".tabCategory");

tabCategory.addEventListener("click", function (evt) {
	
	category_num = 0;
	seeMoreCount = 0;
	
	if(evt.target.innerText == "전체 리스트") {
		sendAjax("http://localhost:8080/reservation/api/products", category_num);
	}
	else if(evt.target.innerText == "전시") {
		 category_num = 1;
		 sendAjax("http://localhost:8080/reservation/api/products/" + category_num, category_num);
	}
	else if(evt.target.innerText == "뮤지컬") {
		 category_num = 2;
		 sendAjax("http://localhost:8080/reservation/api/products/" + category_num, category_num);
	}
	else if(evt.target.innerText == "콘서트") {
		 category_num = 3;
		 sendAjax("http://localhost:8080/reservation/api/products/" + category_num, category_num);
	}
	else if(evt.target.innerText == "클래식") {
		 category_num = 4;
		 sendAjax("http://localhost:8080/reservation/api/products/" + category_num, category_num);
	}
	else if(evt.target.innerText == "연극") {
		 category_num = 5;
		 sendAjax("http://localhost:8080/reservation/api/products/" + category_num, category_num);
	}
	else {
		return;
	}
});

//더보기 눌렸을 때 
var seeMore = document.querySelector(".seeMore");

seeMore.addEventListener("click", function (evt) {
	
	if(evt.target.innerText == "더보기") {
		seeMoreCount++;
//		console.log(seeMoreCount); 
//		console.log(category_num); 
		
		if(category_num == 0) {   //전체 리스트 보기 
			sendAjax("http://localhost:8080/reservation/api/products?start="+ 4*seeMoreCount, category_num);
		}
		else {                    //카테고리 별 보기 
			sendAjax("http://localhost:8080/reservation/api/products/" + category_num + "?start="+ 4*seeMoreCount, category_num);
		}
	}
});

//첫 화면일 때
document.addEventListener("DOMContentLoaded", function(){
	category_num = 0;
	seeMoreCount = 0;
	
	sendAjax("http://localhost:8080/reservation/api/products", category_num);
});



