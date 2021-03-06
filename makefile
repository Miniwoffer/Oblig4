BUILD=build/

All: build_dir $(BUILD)Oblig4.class $(BUILD)GUI.class

jar: gui
	cd $(BUILD); jar cfe GUI.jar GUI *.class shape/*.class geometric/*.class gui/*.class images/*

oblig: build_dir $(BUILD)Oblig4.class

gui: build_dir $(BUILD)GUI.class

run_gui: gui
	cd $(BUILD); java GUI

run_oblig: oblig
	cd build/; java Oblig4

$(BUILD)Oblig4.class: $(BUILD)geometric/*.class Oblig4.java
	javac Oblig4.java Debug.java -d $(BUILD)

$(BUILD)GUI.class: GUI.java $(BUILD)gui/*.class
	javac GUI.java -d $(BUILD)

$(BUILD)geometric/*.class: geometric/*.java
	javac geometric/*.java -d $(BUILD)

$(BUILD)gui/*.class: gui/*.java $(BUILD)geometric/*.class $(BUILD)shape/*.class
	javac gui/*.java -d  $(BUILD)

$(BUILD)shape/*.class: shape/*.java
	javac shape/*.java -d $(BUILD)

#cleans the build directory
build_dir:
	rm -rf $(BUILD)
	mkdir $(BUILD)
	mkdir $(BUILD)/images
	cp images/* $(BUILD)/images

clean: build/
	rm -rf $(BUILD)
