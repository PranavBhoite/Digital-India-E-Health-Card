
// Wrap every letter in a span
var textWrapper = document.querySelector('.ml6 .letters');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({ loop: true })
    .add({
        targets: '.ml6 .letter',
        translateY: ["1.1em", 0],
        translateZ: 0,
        duration: 750,
        delay: (el, i) => 50 * i
    }).add({
        targets: '.ml6',
        opacity: 0,
        duration: 1000,
        easing: "easeOutExpo",
        delay: 1000
    });


//Show Password
function ShowPassword() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

$("input[type='password'][data-eye]").each(function(i) {
    var $this = $(this),
        id = 'eye-password-' + i,
        el = $('#' + id);

    $this.wrap($("<div/>", {
        style: 'position:relative',
        id: id
    }));

    $this.css({
        paddingRight: 60
    });
    $this.after($("<div/>", {
        html: 'Show',
        class: 'btn btn-primary btn-sm',
        id: 'passeye-toggle-' + i,
    }).css({
        position: 'absolute',
        right: 10,
        top: ($this.outerHeight() / 2) - 12,
        padding: '2px 7px',
        fontSize: 12,
        cursor: 'pointer',
    }));

    $this.after($("<input/>", {
        type: 'hidden',
        id: 'passeye-' + i
    }));

    var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

    if (invalid_feedback.length) {
        $this.after(invalid_feedback.clone());
    }

    $this.on("keyup paste", function() {
        $("#passeye-" + i).val($(this).val());
    });
    $("#passeye-toggle-" + i).on("click", function() {
        if ($this.hasClass("show")) {
            $this.attr('type', 'password');
            $this.removeClass("show");
            $(this).removeClass("btn-outline-primary");
        } else {
            $this.attr('type', 'text');
            $this.val($("#passeye-" + i).val());
            $this.addClass("show");
            $(this).addClass("btn-outline-primary");
        }
    });
});

$(".my-login-validation").submit(function() {
    var form = $(this);
    if (form[0].checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
    }
    form.addClass('was-validated');
});