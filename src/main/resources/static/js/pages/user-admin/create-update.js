$(document).ready(function () {

   const userApiUrl = "/api/v1/user-admin";
   let data = {};
   const d = new Date();
   const month = d.getMonth() + 1;
   const day = d.getDate();

   const createDate = d.getFullYear() + '-' +
        (month < 10 ? '0' : '') + month + '-' +
        (day < 10 ? '0' : '') + day;


   const fullName = $("#fullName");
   const username = $("#username");
   const pwd = $("#pwd");
   const confPwd = $("#confPwd");

    function validateAndAssignData() {

        let isValidate = validateInputField(
           [
               fullName,
               username,
               pwd,
               confPwd
           ]
       );

       if (!isValidate) return false;

       if (pwd.val() !== confPwd.val()) {
           toastAlertInfo("Password not match");
           confPwd.focus();
           return false;
       }

        data = {
           "full_name": fullName.val(),
           "username": username.val(),
            "password": pwd.val(),
            "create_at": createDate,
           "update_at": action === "update" ? createDate : '',
           "login_count": 0
       };
       return true;
   }

    $('#create').on('click',function() {
        if(validateAndAssignData()){
            // console.log(data);
            saveUser();
        }

    });

    $('#update').on('click',function() {
        validateAndAssignData();
        data['adm_seq'] = adminId.adm_seq;
        updateUser();
    });

   function saveUser() {
       postRequest(userApiUrl, data, dataRes => {
           if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
               toastAlertSuccessBigNoBtn("User Created").then(() => $(location).attr('href', "/user-admin"))
           } else {
               toastAlertInfo(dataRes.responseJSON.message);
           }
       })
   }

   function updateUser() {
       putRequest(userApiUrl, data, dataRes => {
           if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
               toastAlertSuccessBigNoBtn("User Updated").then(() => $(location).attr('href', "/user-admin"))
           } else {
               toastAlertInfo(dataRes.responseJSON.message);
           }
       })
   }

});
