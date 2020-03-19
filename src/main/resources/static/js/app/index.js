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
            url: '/api/masks?address=' + address
        }).done(function () {
            window.location.href = '/api/masks?address=' + address;
        }).fail(function (error) {
            alert("Error");
        });
    }
};

main.init();
