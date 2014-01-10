UPDATE prize
SET total_count = total_count - 7000,
current_count = current_count - 7000
WHERE prize_id = 1;

UPDATE prize
SET active_yn = 'N'
WHERE prize_id IN(2,3,4,5);

SELECT
u.user_id,
u.user_name,
p.prize_name,
COUNT(1)
FROM reward r
INNER JOIN weibo_user u
ON u.user_id = r.user_id
INNER JOIN prize p
ON p.prize_id = r.prize_id
GROUP BY r.user_id,r.prize_id
