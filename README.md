# NTT-DATA-Test
Technical test

Instalación:

En caso de querer tener la base de datos fuera del contenedor Restaure la Base de Datos BaseDatos.sql 
Debe asegurarse de tener unusuario con las credenciales:
Usuario:test
Clave:test

Si no puede obviar este paso 

Ejecute en un terminal 

Ir a la raíz carpeta del proyecto NTT-DATA

docker-compose up

Importe en Postman el archivo documentation.json

![image](https://user-images.githubusercontent.com/38479147/208014127-b30bc597-a2f1-495e-9650-e78b47288e7d.png)


NOTA:
Si desea obviar el paso anterior, Lo puede hacer ya que el aplicativo cuenta con SWAGGER para la documentación del API, por lo que podemos acceder directamente a sus end Points

![image](https://user-images.githubusercontent.com/38479147/208014405-b18c6d8c-4700-44e7-b9a2-a82536dcfe5b.png)
