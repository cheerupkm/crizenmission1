<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission1/watch</title>
<style>
.time {
  background-color: #000000;
  color: #ffffff;
  font-weight: bold;
  font-size: 20px;
  text-align: center;
  border: 0;
}
</style>
<link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<!-- <body onload="showtime()" onunload="killtime()"> -->
  <body>
  <form name="myform">
    <div id="clock" class="time"></div>
    <!-- <input type="text" id="clock" name="clock" size="50" class="time" readonly> -->
  </form>
  
<script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
<script>
  //ajax 객체의 기본값 지정
  $.ajaxSetup({datatype:"text"});
  
  $(document).ready(function() {
    setInterval(function() {
      showTime();
      },1000);
  }); //ready() end

  function showTime() {
    //alert("test");
    $.get("timer.do", watchView);
  }//showTime() end

  function watchView(result) {
    //alert(result);
    var str = "현재시간은 ";
    str += result + "입니다";
    $("#clock").empty();
    $("#clock").text(str);
  }//watchView() end
</script>

</body>
</html>