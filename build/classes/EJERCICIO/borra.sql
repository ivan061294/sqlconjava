DELIMITER $$
drop PROCEDURE if exists Borrar_Dispositivo;
CREATE PROCEDURE Borrar_Dispositivo(
IN des_dispositivo VARCHAR(30),
)
BEGIN
DELETE FROM dispositivo where des_dispositivo=des_dispositivo
end$$
DELIMITER ;


