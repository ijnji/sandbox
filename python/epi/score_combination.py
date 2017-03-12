# Description:
#
# Given a list of plays, their individual worth in score points, and
# a total score, return the number of all combinations of plays that
# sum up to the given total score.

from rlib.testing import expect

def combinations(total_score, play_scores):
    memo = []
    for i, score in enumerate(play_scores):
        row = []
        for j in xrange(total_score + 1):
            c = 0
            if i == 0:
                if (j % score == 0): c = 1
            else:
                prow = memo[i - 1]
                for k in xrange(j, -1, -score): c += prow[k]
            row.append(c)
        memo.append(row)
    return memo[-1][total_score]

def small_test():
    playScores = [2]
    expect(combinations(1, playScores)).to_be(0)
    expect(combinations(2, playScores)).to_be(1)
    playScores = [2, 3, 7]
    expect(combinations(5, playScores)).to_be(1)
    expect(combinations(9, playScores)).to_be(3)
    expect(combinations(12, playScores)).to_be(4)
    playScores = [1, 5, 10, 25]
    expect(combinations(5, playScores)).to_be(2)
    expect(combinations(10, playScores)).to_be(4)
    expect(combinations(50, playScores)).to_be(49)

if __name__ == '__main__':
    small_test()