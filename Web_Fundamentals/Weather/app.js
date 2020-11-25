$('document').ready(function() {
  $('form').submit(() => {
    const inputText = $('#text-input').val();
    const apiKey = 'a374366cb288cfff9c112ecadb7338bd';
    const url = `http://api.openweathermap.org/data/2.5/weather?q=${inputText}&&appid=${apiKey}`

    const htmlTemplate = ({ name, sys, main, weather }) => (
      `
        <div class="container">
          <h1 id="city">${name} <span>${sys.country}</span></h1>
          <h1 id="temp">${Math.round(main.temp - 273.17)}°</h1>
          <h2 id="type">${weather[0].main}</h2>
        </div>
      `
    )

    $.get(url, res => {
      $('.result').html(htmlTemplate(res));
      
      const type = res.weather[0].main;
      const currentClass = $('main').attr('class');
      const backgroundTypes = {
        Clear: "clear",
        Clouds: "clouds",
        Mist: "mist"
      }
      $('main').removeClass(currentClass).addClass(backgroundTypes[type]);
    }, 'json').fail((error) => {
      alert(`City ${inputText} is not valid`);
    });

    $('#text-input').val("");
    return false;
  })
})