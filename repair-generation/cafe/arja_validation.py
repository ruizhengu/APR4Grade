import json
import re
from pathlib import Path

import utils


class ArjaValidation:
    def __init__(self):
        self.submission_path = Path("/Users/ruizhengu/Experiments/APR4Grade/IntermediateJava")
        self.arja_path = Path("/Users/ruizhengu/Experiments/APR-as-AAT/arja")
        self.negative_tests_json = Path("/Users/ruizhengu/Projects/APR4Grade/repair-generation/lib/negative_tests.json")
        self.submission_list = [submission for submission in self.submission_path.iterdir() if
                                submission.is_dir() and submission.name != ".git"]

    def get_num_negative_tests_arja(self):
        negative_tests_data = {}
        for submission in self.submission_list:
            path_src = submission / "src"
            path_bin_src = submission / "build/classes/java/main"
            path_bin_test = submission / "build/classes/java/test"
            path_dependency = Path("/Users/ruizhengu/Projects/APR4Grade/dependency")
            dependencies = [str(file) for file in path_dependency.glob('**/*.jar') if file.name != ".DS_Store"]
            dependencies = ":".join(dependencies)
            arja_cmd = f"cd {self.arja_path} && java -cp \"lib/*:bin\" us.msu.cse.repair.Main ArjaE -DsrcJavaDir {path_src} -DbinJavaDir {path_bin_src} -DbinTestDir {path_bin_test} -Ddependences {dependencies}"
            arja_output = utils.run_cmd(arja_cmd)
            pattern = r"Number of negative tests: (\d+)"
            match = re.search(pattern, arja_output)
            if match:
                negative_tests = int(match.group(1))
                print(f"{submission.name} > Number of negative tests:", negative_tests)
                negative_tests_data[submission.name] = negative_tests
                with open(self.negative_tests_json, "w") as f:
                    f.write(json.dumps(negative_tests_data, indent=4))
            else:
                print("The pattern was not found in the text.")

    def get_num_failed_tests_gradle(self):
        failed_tests_data = {}


if __name__ == '__main__':
    v = ArjaValidation()
    v.get_num_negative_tests_arja()
