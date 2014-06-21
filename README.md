ELO 329 - Tarea 2
=================

Compilación
-----------

En éste directorio se encuentra la carpeta de la 'etapa 4'. En esta se
encuentra un 'Makefile':

	>> make 		: compila *.java y genera los archivos *.class.
	>> make jar		: genera PhysicsLab.jar
	>> make run		: ejecuta el programa desde el jar (es necesario hace make && make jar antes de run)
	>> mkae runApplet 	: ejecuta el applet usando el jar (idem que 'make run')
	>> make clean 		: elimina *.class compilados y PhysicsLab.jar.

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

Además se ha agregado la opción de correr la aplicación como Applet embebido en un archivo HTML. En el HTML se pueden especificar la cantididad de elementos a agregar en el applet, la ubicación, y en algunos casos los aspectos físicos de estos. 

Para agregar elementos y configuraciones de la applet basta agregar las siguientes lineas HTML:

**Número de Elementos:**

    <param name="<Element>Num" value="<numero de FixedHook>"/> 

**Posición de FixedHook:**

    <param name="fixedHook.x" value="position"/> where x is position
    
**Parámetros de Esferas**

    <param name="ball.x" value="speed; mass; pos_x;radius "/>
    
**Parámetros de Osciladores**

    <param name="oscillator.x" value="amplitude; frequency; position"/>
    
**Tiempo de Muestreo y de Refresco**

    <param name="deltaTime" value="time in seconds"/>

    <param name="refreshTime" value="time in seconds"/>

**Título de Frame**

    <param name="title" value="Title"/> 
 

