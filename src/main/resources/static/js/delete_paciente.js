function deleteBy(id)
{

          const url = 'http://localhost:8080/paciente/eliminar/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())


          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

}