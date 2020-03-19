var baseUrl = "https://pickme-back.ga";
var main = {
    init: function () {
        var _this = this;
        $('#btn-enter').on('click', function() {
            _this.enter();
        });
    },
    enter : function () {
        var address = $('#address').val();

        $.ajax({
            type: 'GET',
            url: baseUrl + '/api/masks?address=' + address
        }).done(function () {
            window.location.href = baseUrl + '/api/masks?address=' + address;
        }).fail(function (error) {
            alert("Error");
        });
    }
};

main.init();
