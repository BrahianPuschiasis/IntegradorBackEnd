window.addEventListener('load', function () {
  const formulario = document.querySelector('#add_new_turno');

  formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = {
      odontologo: {
        id: document.querySelector('#odontologo').value
      },
      paciente: {
        id: document.querySelector('#paciente').value
      },
      fechaHora: document.querySelector('#fechaHora').value
    };

    const url = '/turno/guardar';
    const settings = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        let successAlert =
          '<div class="alert alert-success alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong></strong> Turno agregado </div>';

        document.querySelector('#response').innerHTML = successAlert;
        document.querySelector('#response').style.display = 'block';
        resetUploadForm();
      })
      .catch(error => {
        let errorAlert =
          '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong>Error, intente nuevamente</strong></div>';

        document.querySelector('#response').innerHTML = errorAlert;
        document.querySelector('#response').style.display = 'block';
        resetUploadForm();
      });
  });

  function resetUploadForm() {
    document.querySelector('#odontologo').value = '';
    document.querySelector('#paciente').value = '';
    document.querySelector('#fechaHora').value = '';
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === '/') {
      document.querySelector('.nav .nav-item a:first').classList.add('active');
    } else if (pathname === '/turnoList.html') {
      document.querySelector('.nav .nav-item a:last').classList.add('active');
    }
  })();
});
