#!/usr/bin/env bash

function main() {
  cd ./City-Managment-frontend/
  sh ./build.sh
  cd ../
  cd ./City-Mangament-Gateway/
  sh ./build.sh
  cd ../
  cd ./Citizen-Service/
  sh ./build.sh
  cd ../
  cd ./City-service/
  sh ./build.sh
  cd ../
}

main "$@"
