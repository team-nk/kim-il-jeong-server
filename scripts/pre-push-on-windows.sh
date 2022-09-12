echo "Running lint check.."

./gradlew ktlintCheck --daemon

status=$?

[$status -ne 0] $$ 1
exit 0