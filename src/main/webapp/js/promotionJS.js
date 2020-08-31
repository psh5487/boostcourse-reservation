// 이동시간간격 3초 
var moveSpeed = 3000;

function imgMove(data){ 
	// 맨처음 이미지의 폭 
//	var aWidth = $(".promotion").width()/data.list.length; 
	var aWidth = $(".promotion > div:first").width();
	
	// 롤링마지막에 맨처음의 div 태그 추가 
	$(".promotion").append("<div>" + $(".promotion > div:first").html() + "</div>"); 
	
	// 맨처음이미지를 왼쪽으로 이동시킨다. 
	$(".promotion > div:first").animate({marginLeft:-aWidth},{duration:moveSpeed, complete:function(){ 
		 // 이동을 마친후 첫번째 div 태그를 지워버린다 
		 $(this).remove(); 
		 // 이미지 움직이는것을 다시 실행 
		 imgMove(data); 
	}}); 
 } 
 
function makePromotionTemplate(data) {
	var htmlPromotion = document.getElementById("promotionArea").innerHTML;

    var promotionHTML = "";
    for (var i = 0; i < data.list.length; i++) {
       promotionHTML = htmlPromotion.replace("{save_file_name}", data.list[i].save_file_name);
       
       var promotions = document.createElement("div");
       promotions.innerHTML = promotionHTML;
       document.querySelector(".promotion").appendChild(promotions);
    }
    
    //롤링 베너 
    imgMove(data);
}

function sendAjaxForPromotion(url) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {

    	var data = JSON.parse(oReq.responseText);
//    	console.log(typeof data); //object
//    	console.log(data);
    	
        makePromotionTemplate(data);
    	
    });
    oReq.open("GET", url);
    oReq.send();
}

//첫 화면 
document.addEventListener("DOMContentLoaded", function(){
	sendAjaxForPromotion("http://localhost:8080/reservation/api/promotions");
});

