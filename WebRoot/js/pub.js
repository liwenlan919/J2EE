function setSelectV(id){
	var arr=eval(id);
	$("#"+id).html("<select id='"+id+"_' name='uvo.u_did'></select>");
	for(var i=0;i<arr.length;i++){
		$("#"+id+"_").append('<option value="'+arr[i][0]+'">'+arr[i][1]+'</option>');
	}
	return true;
}

function setSelectVS(id){
	var arr=eval(id);
	for(var i=0;i<arr.length;i++){
		$("#"+id).append('<input type="checkbox"  name="'+id+'" value="'+arr[i][0]+'"/>&nbsp;'+arr[i][1]);
	}
	return true;
}

function setSelectVS_(id){
	var arr=eval(id);
	for(var i=0;i<arr.length;i++){
		$("#"+id).append('<input type="checkbox" name="'+id+'" value="'+arr[i][0]+'"/>&nbsp;<img src="../images/'+arr[i][1]+'"/>');
	}
	return true;
}

function selectV(id,val){
	var arr=eval(id);
	$("#"+id).html("<select id='"+id+"_' name='"+id+"'></select>");
	for(var j=0;j<arr.length;j++){
		if(val==arr[j][0]){
			$("#"+id+"_").append('<option value="'+arr[j][0]+'" selected="selected">'+arr[j][1]+'</option>');
		}else{
			$("#"+id+"_").append('<option value="'+arr[j][0]+'">'+arr[j][1]+'</option>');
		}
	}
	return true;
}


function selectVS(id,val){
 	var t = true;
	var arr=eval(id);
	var valist=val.split(",");
	for(var j=0;j<arr.length;j++){
		for(var i=0;i<valist.length;i++){
			if(valist[i]==arr[j][0]){
				t = false;
				$("#"+id).append('<input type="checkbox" checked="checked"  name="'+id+'" value="'+arr[j][0]+'"/>&nbsp;'+arr[j][1]);
			}
		}
		if(t){
			$("#"+id).append('<input type="checkbox"  name="'+id+'" value="'+arr[j][0]+'"/>&nbsp;'+arr[j][1]);
		}else{
			t = true;
		}
	}
	return true;
}

function selectVS_(id,val){
 	var t = true;
	var arr=eval(id);
	var valist=val.split(",");
	for(var j=0;j<arr.length;j++){
		for(var i=0;i<valist.length;i++){
			if(valist[i]==arr[j][0]){
				t = false;
				$("#"+id).append('<input type="checkbox" checked="checked" name="'+id+'" value="'+arr[j][0]+'"/>&nbsp;<img src="../images/'+arr[j][1]+'"/>');
			}
		}
		if(t){
			$("#"+id).append('<input type="checkbox" name="'+id+'" value="'+arr[j][0]+'"/>&nbsp;<img src="../images/'+arr[j][1]+'"/>');
		}else{
			t = true;
		}
	}
	return true;
}

function setse(id,val,s){
	var arr=eval(id);
	for(var i=0;i<arr.length;i++){
		if(val == arr[i][0]){
			$("#"+id+"_"+s).append(arr[i][1]);
			break;
		}
	}
	return true;
}

function setchar(id,val,s){
	var arr=eval(id);
	var valist=val.split(",");
	for(var i=0;i<valist.length;i++){
		for(var j=0;j<arr.length;j++){
			if(valist[i]==arr[j][0]){
				$("#"+id+"_"+s).append(arr[j][1]+'&nbsp;');
			}
		}
	}
	return true;
}

function setimg(id,val,s){
	var arr=eval(id);
	var valist=val.split(",");
	for(var i=0;i<valist.length;i++){
		for(var j=0;j<arr.length;j++){
			if(valist[i]==arr[j][0]){
				$("#"+id+"_"+s).append('<img src="../images/'+arr[j][1]+'"/>&nbsp;');
			}
		}
	}
	return true;
}

function setimg_(id,val,s){
	var arr=eval(id);
	var valist=val.split(",");
	for(var i=0;i<valist.length;i++){
		for(var j=0;j<arr.length;j++){
			if(valist[i]==arr[j][0]){
				$("#"+id+"_"+s).append('<img src="images/'+arr[j][1]+'"/>&nbsp;');
			}
		}
	}
	return true;
}

function setRadio(id){
	var arr=eval(id);
	for(var i=0;i<arr.length;i++){
		$("#"+id).append('<input type="radio"  name="'+id+'" value="'+arr[i][0]+'"/>&nbsp;'+arr[i][1]);
	}
	return true;
}

function setInp(id){
	var arr=eval(id);
	for(var i=0;i<arr.length;i++){
		$("#"+id).append('<span class="green"><a href="#">'+arr[i][1]+'</a></span>&nbsp;&nbsp;');
	}
	return true;
}
function setInps(id){
	var arr=eval(id);
	for(var i=0;i<arr.length;i++){
		$("#"+id).append('<span class="green"><a href=hotel.do?m=list&h_position='+arr[i][0]+'>'+arr[i][1]+'</a></span>&nbsp;&nbsp;');
	}
	return true;
}
