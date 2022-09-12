echo "Running lint check.."

./gradlew ktlintCheck --daemon

status=$?

[ $status -ne 0] && exit 1
exit
