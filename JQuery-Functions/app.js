$('document').ready(function() {
  $('#click button').click(function() {
    $('#click p').css('color', 'red');
  })

  $('#hide button').click(function() {
    $('#hide p').hide();
  })

  $('#show button').click(function() {
    $('#show p').show();
  })

  $('#toggle button').click(function() {
    $('#toggle p').toggle();
  })

  $('#slide-down button').click(function() {
    $('#slide-down p').slideDown();
  })

  $('#slide-up button').click(function() {
    $('#slide-up p').slideUp();
  })

  $('#slide-toggle button').click(function() {
    $('#slide-toggle p').slideToggle();
  })

  $('#fade-in button').click(function() {
    $('#fade-in p').fadeIn();
  })

  $('#fade-out button').click(function() {
    $('#fade-out p').fadeOut();
  })

  $('#add-class button').click(function() {
    $('#add-class p').addClass('red');
  })

  $('#before button').click(function() {
    $('#before p').before('Something ');
  })

  $('#after button').click(function() {
    $('#after p').after(' Something');
  })

  $('#append button').click(function() {
    $('#append').append('<br><p>New Paragraph</p>')
  })

  $('#html button').click(function() {
    let html = $('#html').html();
    $('#html p').text(html);
  })

  $('#attr button').click(function() {
    $('#attr').append('<br>' + ($('#attr p').attr('class')));
  })

  $('#val button').click(function() {
    $('#val').append('<br>' + $('#text').val());
  })

  $('#text button').click(function() {
    $('#text p').text('New Text');
  })
})