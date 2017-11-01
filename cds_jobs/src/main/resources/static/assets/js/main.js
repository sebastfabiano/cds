$(function() {

    // Scrolltop on Load Page
    $(document).ready(function(){
        $(this).scrollTop(0);
     });

    // jQuery for page scrolling feature - requires jQuery Easing plugin
    $(document).on('a.page-scroll', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top - 50)
        }, 1250, 'easeInOutExpo');
        event.preventDefault();
    });

    // Highlight the top nav as scrolling occurs
    $('body').scrollspy({
        target: '.navbar-fixed-top',
        offset: 300
    });

    // Closes the Responsive Menu on Menu Item Click
    $('.navbar-collapse ul li a.page-scroll').click(function() {
        $('.navbar-toggle:visible').click();
    });

});