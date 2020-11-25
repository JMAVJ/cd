$('document').ready(function(){
  $('.card').click(function(){
    $(this).slideUp();
  })

  $('section button').click(function(){
    $('.card').show();
  })
})