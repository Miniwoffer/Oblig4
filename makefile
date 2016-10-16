BUILD=build/

All: build_dir $(BUILD)Oblig4.class $(BUILD)GUIv0.class

oblig: build_dir $(BUILD)Oblig4.class

gui: build_dir $(BUILD)GUIv0.class

run_gui: gui
	cd $(BUILD); java GUIv0

run_oblig: oblig
	cd build/; java Oblig4

build/Oblig4.class: $(BUILD)geometric/*.class Oblig4.java
	javac Oblig4.java -d $(BUILD)

build/GUIv0.class: GUIv0.java
	javac GUIv0.java -d $(BUILD)

$(BUILD)geometric/*.class: geometric/*.java
	javac geometric/*.java -d $(BUILD)


#cleans the build directory
build_dir:
	rm -rf $(BUILD)
	mkdir $(BUILD)

clean: build/
	rm -rf $(BUILD)
