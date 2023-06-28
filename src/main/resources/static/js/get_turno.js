window.addEventListener('load', function () {
  (function () {

    const url = '/turno';
    const settings = {
      method: 'GET'
    };

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        for (turno of data) {


          var table = document.getElementById("turnoTable");
          var turnoRow = table.insertRow();
          let tr_id = 'tr_' + turno.id;
          turnoRow.id = tr_id;


          let deleteButton =
            '<button id="btn_delete_' +
            turno.id +
            '" type="button" onclick="deleteBy(' +
            turno.id +
            ')" class="btn btn-danger btn_delete">&times;</button>';

          let updateButton =
            '<button id="btn_id_' +
            turno.id +
            '" type="button" onclick="findBy(' +
            turno.id +
            ')" class="btn btn-info btn_id">' +
            turno.id +
            '</button>';


         turnoRow.innerHTML =
            '<td>' +
            updateButton +
            '</td>' +
            '<td class="td_paciente">' +
             turno.paciente.id +
            '</td>' +
            '<td class="td_odontologo">' +
             turno.odontologo.id +
            '</td>' +
            '<td class="td_fechaHora">' +
            turno.fechaHora +
            '</td>' +
            '<td>' +
            deleteButton +
            '</td>';
        }
      })
      .catch(error => console.error(error));
  })();

  (function () {
    let pathname = window.location.pathname;
    if (pathname == "/turnoList.html") {
      document.querySelector(".nav .nav-item:last-child a").classList.add("active");
    }
  })();
});
