process.stdin.setEncoding('utf8');
process.stdin.on('data', data => {
    const n = data.split(" ");
    const a = Number(n[0]), b = Number(n[1]);
    let star = "********************"; // 20
    for (let i = 20; i < a; i *= 2) {
        star += star;
    }
    star = star.substring(0, a);
    process.stdout.write(star);
    for (let i = 1; i < b; i++) {
         process.stdout.write('\n' + star);
    }
    
});