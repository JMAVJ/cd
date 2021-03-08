$('document').ready(function () {
  $('#username').focusout(function () {
    const value = $('#username').val();
    const usernameInput = $('#username');
    const usernameExists = $('#username-exists');
    if (!value) {
      return usernameExists.addClass('hidden');
    }
    $.ajax({
      url: `/username/${value}`,
    }).done((res) => {
      if (res.exists) {
        usernameExists.removeClass('hidden');
        usernameExists.html(
          '<p class="text-red-300">The username already exists</p>'
        );

        usernameInput.addClass('border-2 border-red-300');
        usernameInput.removeClass('border-2 border-green-200');
      } else {
        usernameInput.addClass('border-2 border-green-200');
        usernameExists.addClass('hidden');
      }
    });
  });
});
