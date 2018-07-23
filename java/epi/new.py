#!/usr/bin/env python3

"""
Create the templates for a new problem.
"""

import argparse
import os
import re
import sys

main_path = '/src/main/java/moe/ijnji/epi'
test_path = '/src/test/java/moe/ijnji/epi'

root_path = os.path.dirname(os.path.abspath(__file__))
main_path = root_path + main_path
test_path = root_path + test_path

def read_arguments():
    parser = argparse.ArgumentParser()
    parser.add_argument('number',
        help='problem number (eg. "10.1")', type=float)
    parser.add_argument('problem',
        help='problem name (eg. "CountBits")', type=str)
    parser.add_argument('-r', '--readme', action='store_true',
        help='create a new entry in README.md')
    parser.add_argument('-m', '--main', action='store_true',
        help='create a new file in main')
    parser.add_argument('-t', '--test', action='store_true',
        help='create a new file in test')
    args = parser.parse_args()

    if all([not args.readme, not args.main, not args.test]):
        raise Exception('at least one of --readme, --main, and --test must be true')

    return [args.number, args.problem, args.readme, args.main, args.test]

def create_problem(arguments):
    number = arguments[0]
    problem = arguments[1]
    readme = arguments[2]
    main = arguments[3]
    test = arguments[4]

    if readme:
        insert_readme(number, problem)

    if main:
        create_main(number, problem)

    if test:
        create_test(number, problem)

def insert_readme(number, problem):
    def get_current_number(line):
        pattern = re.compile(r'([0-9]+\.[0-9]+)')
        result = pattern.search(line)
        if result is not None:
            return float(result.group(1))
        return None

    src_readme_file = open(root_path + '/README.md', 'r')
    dest_readme_file = open(root_path + 'README.md.new', 'w')
    for line in readme_file:
        current_number = get_current_number(line)
        if current_number is None:
            dest_readme_file.write(line)
            continue
        if current_number > number:



if __name__ == '__main__':
    arguments = read_arguments()
    create_problem(arguments)