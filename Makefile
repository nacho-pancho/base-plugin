SRC := $(wildcard src/main/java/net/changeme/*.java)

all:
	#javac -cp ../spigot-api.jar:../../craftbukkit-1.9.2.jar:. $(SRC)
	javac -cp ../../craftbukkit-1.9.2.jar:src/main/java $(SRC)
	mkdir -p /tmp/jartmp
	cp -r src/main/java/* /tmp/jartmp/
	cp -r src/main/resources/* /tmp/jartmp/
	jar cf BasePlugin-0.0.jar -C /tmp/jartmp .


