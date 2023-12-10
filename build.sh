#!/usr/bin/env bash

function main() {
  echo "Build script of main folder"
  cd ./city-management-gateway/
  sh ./build.sh
  cd ../
  cd ./city-management-frontend/
  sh ./build.sh
  cd ../
  cd ./citizen-service/
  sh ./build.sh
  cd ../
  cd ./city-service/
  sh ./build.sh
  cd ../
  echo "Closing build script at main folder..."
}

main "$@"
