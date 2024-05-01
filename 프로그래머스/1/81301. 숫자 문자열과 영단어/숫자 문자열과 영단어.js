function solution(s) {
    // UTF-16
    let ret = "";
    for (let i = 0; i < s.length; i++) {
        if (s[i] > '9') {
            // 1 z, 1 o, 2 t, 2 f, 2 s, 1 e, 1 n
            switch (s[i]) {
                case 'z':
                    i += 3;
                    ret += '0';
                    break;
                case 'o':
                    i += 2;
                    ret += '1';
                    break;
                case 'e':
                    i += 4;
                    ret += '8';
                    break;
                case 'n':
                    i += 3;
                    ret += '9';
                    break;
                case 't':
                    if (s[i + 1] == 'w') {
                        i += 2;
                        ret += '2';
                    }
                    else {
                        i += 4;
                        ret += '3';
                    }
                    break;
                case 'f':
                    if (s[i + 1] == 'o') {
                        ret += '4';
                    }
                    else {
                        ret += '5';
                    }
                    i += 3;
                    break;
                case 's':
                    if (s[i + 1] == 'i') {
                        i += 2;
                        ret += '6';
                    }
                    else {
                        i += 4;
                        ret += '7';
                    }
                    break;
            }
        }
        else ret += s[i];
    }
    return parseInt(ret);
}