$(document).ready(function(){
	$("#btn").click(function(){
		var a=$("#pwd").val();
		var b=$("#pwd1").val();
        if(a !='' & b!='')
        	{
		if(a == b)
			{
			alert("password sucessfull");
			$('#btn').prop('disabled', false);
			}
		else 
			{
			alert("plz enter valid password");
			$("#form1 input[type='text']").removeData();
			$('#btn').prop('disabled', true);
			}
        	}
        else
        	{
        	alert("plz enter something");
        	$('#btn').prop('disabled', true);
        	}
	});
	$("#pwd1").focusin(function(){
		$('#btn').prop('disabled', false);
	});
});