$(function () {
    $('#getPlacas').on('click', function () {
        $.ajax({
            url: 'http://localhost:8080/EasyParking/api/placas',
            success: function (placas) {
                let tbody = $('tbody')
                tbody.html('');
                placas.forEach(placa => {
                    tbody.append(`
                        <tr>
                        <td width="5" class='id'>${placa.id_vehiculo}</td>
                        <td width="15">
                        <input type="text" class='vehiculo' value="${placa.id_tipo_veh}"</td>
                        <td width="15">
                        <button class="update-button"> Update </button>
                        <button class="delete-button"> Delete </button>
                        </td>
                        </tr>
                        `)
                })
            }
        })
    })
    $('#formPlacas').on('submit', function (e) {
        e.preventDefault()
        let newPlaca = $('#newPlaca')
        $.ajax({
            url: 'http://localhost:8080/EasyParking/api/placas',
            method: 'post',
            data: {
                name: newPlaca.val()
            },
            success: function (response) {
                $('#getPlacas').click()
            }
        })
    })
    $('table').on('click', '.update-button', function () {
        let row = $(this).closest('tr')
        let id = row.find('.id').text()
        let name = row.find('.name').val()

        $.ajax({
            url: 'http://localhost:8080/EasyParking/api/placas/' + id,
            method: 'PUT',
            data: {
                "id_vehiculo": "AAA123",
                "id_tipo_veh": "car",
            },
            success: function (response) {
                console.log(response)
            }
        })
    })
    $('table').on('click', '.delete-button', function () {
        let row = $(this).closest('tr') // obtengo toda la fila que seleccione
        let id = row.find('.id').text();
        $.ajax({
            url: 'http://localhost:8080/EasyParking/api/placas/' + id,
            method: 'delete',
            success: function (response) {
                console.log(response)
                $('#getPlacas').click();
            }
        })
    })
})