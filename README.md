ELO 329 - Tarea 2
=================

Compilación
-----------

En éste directorio se encuentra la carpeta de la 'etapa 4'. En esta se
encuentra un 'Makefile':

	>> make 	: compila *.java de la etapa 4.
	>> make doc 	: crea documentación de las clases Ball, BallView y 
					  MyWorld en el direcotorio 'documentacion'.
	>> make clean 	: elimina *.class compilados.
	>> make cleandoc: elimina documentación creada.

Ejecución
----------

Una vez ejecutado 'make', se puede correr el programa con

------ Applet
	>> java PhysicsLab

Con esto se despliega una ventana con un menu y un area para visualizar
los elementos físicos.
-------- Applet

Para agregar un nuevo elemento se debe ingresar a "Configuration->Insert"
y se puede seleccionar el elemento deseado.

Al apretar "Start" se comienza la simulación y se pierde la capacidad de mover los
elementos. Para intervenir se debe para la simulación con "Stop", agregar o mover lo que
se desea, y luego "Start" para seguir la simulación.

Se ha agregado un gráfico que muestra energía potencial y cinética totales. Con esto
se agregó un nuevo menu para trabajar con el gráfico, en el que se tiene un
subitem "Clear Plot" con el que se puede borrar lo graficado en el plot, sin perder
la referencia de tiempo orignal.

