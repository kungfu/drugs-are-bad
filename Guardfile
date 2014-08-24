# Pulled from http://pbrisbin.com/posts/automated_unit_testing_in_haskell/
# also needs:
#   apt-get install ruby1.9.1-dev
#   gem install guard-file
#
# Runs the command and prints a notification
def execute(cmd)
  if system(cmd)
    n 'Build succeeded', 'lein test', :success
  else
    n 'Build failed', 'lein test', :failed
  end
end

def run_all_tests
  execute %{
    lein test
  }
end

guard :shell do
  watch(%r{src/(.+)\.clj$})  { run_all_tests }
  watch(%r{test/(.+)\.clj$}) { run_all_tests }
end
