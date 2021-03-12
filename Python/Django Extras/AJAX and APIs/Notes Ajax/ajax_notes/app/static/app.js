$('document').ready(() => {
  function getCookie(name) {
    var cookie = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return cookie ? cookie[2] : null;
  }

  function updateNotes() {
    $.ajax({
      url: '/get-notes',
      method: 'GET',
    }).done((res) => {
      $('#notes-container').empty();
      res.forEach((note) => {
        let noteTemplate = `
          <div class="card col-3">
            <div class="card-body">
              <h5 class="card-title">${note.title}</h5>
              <textarea
                rows="5"
                class="form-control"
                style="resize: none"
              >${note.description}</textarea>
              <form action="/delete-note" method="POST" class="note-form">
                <input type="hidden" name="csrfmiddlewaretoken" value="${getCookie(
                  'csrftoken'
                )}">
                <input type="hidden" name="note_id" value="${note.id}">
                <input type="submit" value="Delete" class="btn btn-outline-danger"></input>
              </form>
            </div>
          </div>
        `;
        $('#notes-container').append(noteTemplate);
      });
    });
  }

  $('#notes-container').on('submit', '.note-form', function (e) {
    console.log('a');
    e.preventDefault();

    console.log($(this));

    $.ajax({
      url: '/delete-note',
      method: 'POST',
      data: $(this).serialize(),
    }).done(() => {
      updateNotes();
    });

    updateNotes();
  });

  $('form').submit(function (e) {
    console.log('b');
    e.preventDefault();

    $.ajax({
      url: $(this).attr('action'),
      method: 'POST',
      data: $(this).serialize(),
    }).done(() => {
      updateNotes();
    });
  });

  updateNotes();
});
