var obje;
var na;
  $(document).ready(function()
	{
	 $("#btn").click(function()
		{
		 $("#mydiv input").remove();
		// alert($( "#myselect option:selected" ).text());
		 var x= $("#myselect option:selected").text();
		 if(x == "ADDITION" | x == "SUBTRACTION"| x == "MULTIFLICATION" | x == "DIVISION")
			{
			  $('<input/>').attr( { type: 'text', id: 'num1', name: 'test1', placeholder: 'EnterFirstNumber' }).appendTo('#mydiv').focus(); 
		      $('<input/>').attr( { type: 'text', id: 'num2', name: 'test2', placeholder: 'EnterSecondNumber' }).appendTo('#mydiv').focus();
		      $('<input/>').attr( { type: 'submit', id: 'add', name: 'test3', placeholder: 'ADD' }).appendTo('#mydiv').focus();
			}
		  else 
		    {
			  $('<input/>').attr( { type: 'text', id: 'num3', name: 'test4', placeholder: 'EnterFirstNumber' }).appendTo('#mydiv').focus();
			  $('<input/>').attr( { type: 'submit', id: 'sqa', name: 'test5', placeholder: 'SQR' }).appendTo('#mydiv').focus();
			}
	          $("#add").click(function(){
	    	  var nm1= $("#num1").val();
	    	  var nm2= $("#num2").val();
	    	  $.get("Addition.jsp",{number1:nm1,number2:nm2,sai:x},function(data)
	    			 {
	    		      $("#result").html(data);
	    	        });
	         });
	    	 $("#sqa").click(function(){
	    		
		    	 var nm3= $("#num3").val();
		    	// alert(nm3);
		    	 $.get("Square.jsp",{number3:nm3,sai:x},function(data)
		    			 {
		    		    $("#result").html(data);
		    	 });
	     });
		$.get("taskperformer.jsp",{sai:x},function(data){
		    //alert(data);
		});
	 });
	 $("#details").click(function()
			 {
		     $.get("details.jsp",function(data)
			   {
			 $("#send").html(data);
			  });
			 });
	 
	 $("#opr").click(function()
			 {
		      //var a=$("#myselect").val();
		      //alert("hi");
		         /*var a = [];
		         $("#myselect option").each(function(){
		    	     a.push($(this).val());
		    	   //alert($(this).val());
		         });
		           for(var i=0; i<a.length; i++)
		    	   {
		    	   // alert(a[i]);
		    	   }
		            var b=$("#tolselect option:selected").val();
		    	    var c=$.inArray(b,a);
		    	    if(c == -1)
		    	    	{
		    	    	var x = document.getElementById("myselect");
		    	        var option = document.createElement("option");
		    	        option.text = b;
		    	        x.add(option);
		    	    	//alert("hi");
		    	    //	$("#myselect").append("<option value='b'>'b'</option>");
		    	    	}
		    	       else
		    	    	{
		    	    	alert("already exisits");
		    	    	}*/
		    	    //alert(c);
		    	   /*var b=$("#tolselect option:selected").val();
		    	      if(a == b)
		    		   {
		    		  alert("available");
		    		   }
		    	      else
		    	       {
		    	     return false;
		    	      alert("not available");
		    	       }
		     //alert($("#tolselect option:selected").val());
		     $("#send").text(a);*/
		 var b=$("#tolselect option:selected").val();
		    	    $.get("AdminOperations.jsp",{operation:b},function(data)
		  	    		  {
		                     alert(data.info);   
		                     /*for(var a=0;a<data.author.length;a++)
		                	      {
		                        var x = document.getElementById("myselect");
		    	              var option = document.createElement("option");
		    	              option.text = data.author[a];
		    	              x.add(option);
		                	  }*/
		  	    		  });
			 });
	      $.get("Role.jsp",function(data)
	    		  {
	    		     //alert(data);
	    		     if(data =='null')
	  	    	        {
	  	    		     // alert("Please Login Once Again Your Session No More");
	  	    		      window.location.href="http://localhost:7777/Test/UserLogin.html";
	  	    	        }
	    		     else if(data == "sairam")
			          {
			           $("#tolselect").prop('disabled', false);
			           $("#opr").prop('disabled', false);
			          }	 
		             else
		              {
		        	           $("#tolselect").hide();
		        	           $("#opr").hide();
		        	           $("#spn1").hide();
			                   $("#tolselect").prop('disabled', true);
			                  $("#opr").prop('disabled', true);
		              }
	 });
	      $.get("Operations.jsp",function(data)
	    		  {
                   //alert(data.author.length);   
                   for(var a=0;a<data.author.length;a++)
              	      {
                      var x = document.getElementById("myselect");
  	              var option = document.createElement("option");
  	              option.text = data.author[a];
  	              x.add(option);
              	  }
         });
  });
