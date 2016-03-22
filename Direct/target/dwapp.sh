#!/bin/bash
cd /var/gg

rm /dev/random
ln -s /dev/urandom /dev/random

java -jar -Duser.language=en -Duser.region=us dwapp-0.0.1.jar
