$('document').ready(function () {
  $('#search').keyup(function () {
    if ($(this).val().length < 1) {
      $('#suggestions-label').addClass('hidden');
      $('#suggestions').html('');
      return;
    }
    $.ajax({
      url: '/search',
      method: 'POST',
      data: $(this).serialize(),
    }).done(function (res) {
      const languages = res.data;
      $('#suggestions-label').removeClass('hidden');
      $('#suggestions').html(() => {
        let suggestions = [];
        for (let i = 0; i < languages.length; i++) {
          suggestions.push(`<p>${languages[i].name}</p>`);
        }
        return suggestions.join('');
      });
    });
  });
});
