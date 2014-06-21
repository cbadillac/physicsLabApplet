JFLAGS = -g
JC = javac
JAR = jar -cvfm
JARNAME = PhysicsLab.jar
JARCLASS = PhysicsLabApplet.class
CLASSPATH = .:jfreechart.jar:jcommon.jar
RM = rm

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) -cp $(CLASSPATH) $*.java

# Compile
SOURCES = \
	Ball.java \
	BallView.java \
	Spring.java \
	SpringView.java \
	SpringAttachable.java \
	FixedHook.java \
	FixedHookView.java \
	LabMenuListener.java \
	MouseListener.java \
	MyWorld.java \
	MyWorldView.java \
	Simulateable.java \
	PhysicsElement.java \
	PhysicsLab.java \
	PhysicsLabApplet.java

CLASSES = \
        Ball.class \
        BallView.class \
        Spring.class \
        SpringView.class \
        SpringAttachable.class \
        FixedHook.class \
        FixedHookView.class \
        LabMenuListener.class \
        MouseListener.class \
        MyWorld.class \
        MyWorldView.class \
        Simulateable.class \
        PhysicsElement.class \
        PhysicsLab.class \
        PhysicsLabApplet.class


default: classes

classes: $(SOURCES:.java=.class)

clean:
	$(RM) *.class $(JARNAME)
	
jar:
	$(JAR) $(JARNAME) Manifest.mf *.class

run:
	java -jar $(JARNAME)

runApplet:
	appletviewer -J-classpath -J$(JARNAME) applet.html

