#!/usr/bin/env python3

"""
Create the templates for a new problem.
"""

import argparse
import os
import re
import sys

main_relative_path = '/src/main/java/moe/ijnji/epi'
test_relative_path = '/src/test/java/moe/ijnji/epi'
root_path = os.path.dirname(os.path.abspath(__file__))

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
        create_main(problem)

    if test:
        create_test(problem)

def insert_readme(number, problem):
    def infer_chapter_number(line):
        pattern = re.compile(r'^\s*([0-9]+)\.')
        result = pattern.search(line)
        if result:
            return int(result.group(1))
        return None

    def infer_problem_number(line):
        pattern = re.compile(r'\s*\*\s*[0-9]+\.([0-9]+):')
        result = pattern.search(line)
        if result:
            return int(result.group(1))
        return None

    def get_entry(number, problem):
        return '    * {}: [{}.java](.{}/{}.java) ([Test](.{}/{}.java))\n' \
            .format(number, problem, main_relative_path, problem, test_relative_path, problem)

    src_readme_file = open('{}/README.md'.format(root_path), 'r')
    dest_readme_file = open('{}/README.md.new'.format(root_path), 'w')

    # Move lines into destination file until target problem chapter
    chapter = int(number)
    line = src_readme_file.readline()
    while line:
        inferred_chapter = infer_chapter_number(line)
        if inferred_chapter == chapter:
            dest_readme_file.write(line)
            break
        else:
            dest_readme_file.write(line)
        line = src_readme_file.readline()

    # Move lines into destination file until target problem number or a new chapter
    line = src_readme_file.readline()
    while line:
        inferred_chapter = infer_chapter_number(line)
        inferred_number = infer_problem_number(line)
        if inferred_chapter:
            dest_readme_file.write(get_entry(number, problem))
            dest_readme_file.write(line)
            break
        elif inferred_number < number:
            dest_readme_file.write(line)
        elif inferred_number == number:
            dest_readme_file.write(get_entry(number, problem))
            break
        else:
            dest_readme_file.write(get_entry(number, problem))
            dest_readme_file.write(line)
            break
        line = src_readme_file.readline()

    # Move remaining lines
    line = src_readme_file.readline()
    while line:
        dest_readme_file.write(line)
        line = src_readme_file.readline()

    os.rename('{}/README.md'.format(root_path), 'README.md.old')
    os.rename('{}/README.md.new'.format(root_path), 'README.md')

def create_main(problem):
    main_template_file = open('{}{}/MainTemplate.txt'.format(root_path, main_relative_path), 'r')
    main_class_file = open('{}{}/{}.java'.format(root_path, main_relative_path, problem), 'w')

    for line in main_template_file:
        pattern = re.compile(r'REPLACE')
        line = pattern.sub(problem, line)
        main_class_file.write(line)

def create_test(problem):
    test_template_file = open('{}{}/TestTemplate.txt'.format(root_path, test_relative_path), 'r')
    test_class_file = open('{}{}/{}Test.java'.format(root_path, test_relative_path, problem), 'w')

    for line in test_template_file:
        pattern = re.compile(r'REPLACE')
        line = pattern.sub('{}Test'.format(problem), line)
        test_class_file.write(line)

if __name__ == '__main__':
    arguments = read_arguments()
    create_problem(arguments)
