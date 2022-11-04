function checkAddMember() {
    let memHp = document.getElementById("memHp");
    let memberName = document.getElementById("memName");
	if(memberName.value == ""){
		alert("이름을 입력해주세요");
		return false;
	}
	

	if(!check(/^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/,memHp,"휴대폰 번호 확인해주세요")){
		
		return false;
	}

    // regExp : 정규식 / e : 대상 객체 / msg : 통과 못하면 출력할 메시지 
    function check(regExp, e, msg){
        if(regExp.test(e.value)){
            return true;
        }

        // 통과하지 못했다면..
        alert(msg);
        e.select();
        e.focus();
        return false;
    }
	
	
	
    document.frm.submit();
}