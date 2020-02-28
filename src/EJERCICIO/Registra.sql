DELIMITER ;
drop PROCEDURE if exists Registra_Dispositivo;
CREATE PROCEDURE Registra_Dispositivo(
IN des_dispositivo VARCHAR(30),
IN precio int,
int tipo VARCHAR(30)
)
BEGIN
insert into dispositivo values (des_dispositivo,precio,tipo);
end$$
DELIMITER ;

