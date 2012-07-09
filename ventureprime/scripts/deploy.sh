#!/bin/bash -ex

# Get current directory
SCRIPTS_DIR=$(pwd)
echo "Building VenturePrime in $SCRIPTS_DIR"

echo "Configuring Python"
virtualenv -q ve
source ./ve/bin/activate
pip install -E ./ve -r requirements.txt
pip install -E ./ve -r requirements-testing.txt
cd $WORKSPACE/projectname
ln -fs `pwd`/conf/testsettings.py `pwd`/localsettings.py
python manage.py migrate
python manage.py jenkins