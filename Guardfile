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

def run_jslint
  execute_jslint %{
    jslint public/js/app.js
  }
end

def execute_jslint(cmd)
  if system(cmd)
    n 'JSLint succeeded', 'jslint', :success
  else
    n 'JSLint failed', 'jslint', :failed
  end
end

guard :shell do
  watch(%r{src/(.+)\.clj$})  { run_all_tests }
  watch(%r{test/(.+)\.clj$}) { run_all_tests }
  watch(%r{public/js/app.js$}) { run_jslint }
end
