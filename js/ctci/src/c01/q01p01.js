'use strict';

function isUnique(str) {
    // Case insensitive.
    str = str.toLowerCase();
    // Experimenting with bit vector for tracking.
    let seen = 0;
    for (let i = 0; i < str.length; i++) {
        let c = str.charCodeAt(i) - 97;
        if ((seen & (1 << c)) > 0) {
            return false;
        } else {
            seen |= (1 << c);
        }
    }
    return true;
}

module.exports = {
    isUnique: isUnique
};