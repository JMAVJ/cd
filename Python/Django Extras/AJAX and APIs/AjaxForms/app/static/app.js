$('document').ready(function () {
  $('#name-form').submit(function (e) {
    e.preventDefault();
    const data = $(this).serialize();
    $.ajax({
      url: '/search-name',
      method: 'GET',
      data,
    }).done((res) => {
      $('#users-table').html('');
      res.forEach((user) => {
        $('#users-table').append(`
          <tr>
            <td>${user.id}</td>
            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.date_joined}</td>
            <td>${user.email}</td>
          </tr>
        `);
      });
    });
  });

  $('#date-form').submit(function (e) {
    e.preventDefault();
    const data = $(this).serialize();
    $.ajax({
      url: '/search-date',
      method: 'GET',
      data,
    }).done((res) => {
      $('#users-table').html('');
      res.forEach((user) => {
        $('#users-table').append(`
          <tr>
            <td>${user.id}</td>
            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.date_joined}</td>
            <td>${user.email}</td>
          </tr>
        `);
      });
    });
  });
});
