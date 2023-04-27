$(document).ready(function () {

    let data = {};
    const getBrUrl = "/api/v1/branches";
    const getLocationUrl = "/api/v1/locations";
    const lat= $("#latitude");
    const lon = $("#longitude");
    const name = $("#name");
    const branch = $("#branch");
    selectBranch("#branch","-- Choose branch --",getBrUrl);

    let qr_code_element = document.querySelector("#qrCode");
    let latitude = document.querySelector("#latitude");
    let longitude = document.querySelector("#longitude");

    // if(action === "update"){
    //     let comOpt = new Option(locationId.name,locationId.company_id, true, true);
    //     branch.append(comOpt).trigger('change');
    //     branch.prop('disabled', 'disabled');
    //     data['loc_seq'] = location.loc_seq;
    // }

    function validateAndAssignData() {

        const branchId = $('#branch').select2('val');

        if (!branchId){
            toastAlertInfo("Please select the branch...!");
        }

        data = {
            "name": name.val(),
            "branch_id": +branchId,
            "latitude": lat.val(),
            "longitude": lon.val()
        };
        return true;
    }

    $('#generate').click(function() {

        if (name.val() !== "" && branch.val() !== "" && latitude.value !== "" && longitude.value !== "") {
            if (qr_code_element.childElementCount === 0) {
                generate(latitude,longitude);
                if(validateAndAssignData()){
                    saveLocation();
                }
            } else {
                qr_code_element.innerHTML = "";
                generate(latitude,longitude);
                if(validateAndAssignData()){
                    saveLocation();
                }
            }
        } else {
            if (name.val() === "")
                toastAlertInfo("Name is valid");
            if (branch.val() === "")
                toastAlertInfo("branchId is valid");
            if (latitude.value === "")
                toastAlertInfo("Latitude is valid");
            if (longitude.value === "")
                toastAlertInfo("Longitude is valid");

            // console.log("not valid input");
            qr_code_element.style = "display: none";
        }

    });

    $('#cancel').click(function () {

        qr_code_element.style = "display: none";
        $('input[type=text]').each(function() {
            $(this).val('');
        });

    });

    function saveLocation() {

        postRequest(getLocationUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Latitude Longitude Created")
                    // .then(() => $(location).attr('href', "/generate"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function updateLocation() {

        putRequest(getLocationUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Latitude Longitude Update")
                    // .then(() => $(location).attr('href', "/generate"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function generate(latitude,longitude) {
        qr_code_element.style = "";
        const qrcode = new QRCode(qr_code_element, {
            text: `${latitude.value + ', ' + longitude.value}`,
            width: 350,
            height: 350,
            colorDark: "#000000",
            colorLight: "#ffffff",
            correctLevel: QRCode.CorrectLevel.H
        });
    }

    function selectBranch(element, placeHolder, getDataUrl) {
        let dataBr = [];
        let br = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            br = res.responseJSON.data;
            // Get Data for Select2
            br.forEach(d => {
                dataBr.push({id: d.branch_seq, text: d.name})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataBr
            });
        })
    }

});